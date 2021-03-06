package de.maxhenkel.car.entity.car.base;

import de.maxhenkel.car.items.ItemRepairTool;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public abstract class EntityCarDamageBase extends EntityCarBatteryBase {

    private static final DataParameter<Float> DAMAGE = EntityDataManager.createKey(EntityCarDamageBase.class, DataSerializers.FLOAT);

    public EntityCarDamageBase(EntityType type, World worldIn) {
        super(type, worldIn);

    }

    @Override
    public void tick() {
        super.tick();
        if (isInLava()) {
            addDamage(1);
        }

        if (isStarted() || getDamage() > 99F) {
            particles();
        }
    }

    public void particles() {
        if (!world.isRemote) {
            return;
        }

        if (getDamage() < 50) {
            return;
        }

        int amount;
        int damage = (int) getDamage();

        if (damage < 70) {
            if (rand.nextInt(10) != 0) {
                return;
            }
            amount = 1;
        } else if (damage < 80) {
            if (rand.nextInt(5) != 0) {
                return;
            }
            amount = 1;
        } else if (damage < 90) {
            amount = 2;
        } else {
            amount = 3;
        }

        for (int i = 0; i < amount; i++) {
            this.world.addParticle(ParticleTypes.LARGE_SMOKE,
                    getPosX() + (rand.nextDouble() - 0.5D) * getCarWidth(),
                    getPosY() + rand.nextDouble() * getCarHeight(),
                    getPosZ() + (rand.nextDouble() - 0.5D) * getCarWidth(),
                    0.0D, 0.0D, 0.0D);
        }

    }

    @Override
    public void onCollision(float speed) {
        super.onCollision(speed);
        float percSpeed = speed / getMaxSpeed();

        if (percSpeed > 0.8F) {
            addDamage(percSpeed * 5);
            playCrashSound();

            if (percSpeed > 0.9F) {
                setStarted(false);
                playStopSound();
            }
        }
    }

    private long lastDamage;

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerable()) {
            return false;
        }

        if (world.isRemote || !isAlive()) {
            return false;
        }

        if (!(source.getImmediateSource() instanceof PlayerEntity)) {
            return false;
        }
        PlayerEntity player = (PlayerEntity) source.getImmediateSource();

        if (player == null) {
            return false;
        }

        if (player.equals(getDriver())) {
            return false;
        }


        ItemStack stack = player.getHeldItemMainhand();

        if (stack.getItem() instanceof ItemRepairTool) {
            long time = player.world.getGameTime();
            if (time - lastDamage < 10L) {
                destroyCar(player, true);
                stack.damageItem(50, player, playerEntity -> playerEntity.sendBreakAnimation(Hand.MAIN_HAND));
            } else {
                lastDamage = time;
            }

            return true;
        }

        return false;
    }

    public void addDamage(float val) {
        setDamage(getDamage() + val);
    }

    @Override
    public boolean canStartCarEngine(PlayerEntity player) {
        boolean b = true;
        if (getDamage() >= 100F) {
            return false;
        }
        return super.canStartCarEngine(player) && b;
    }

    @Override
    public int getTimeToStart() {
        int value = super.getTimeToStart();

        if (getDamage() >= 95) {
            value += rand.nextInt(25) + 50;
        } else if (getDamage() >= 90) {
            value += rand.nextInt(15) + 30;
        } else if (getDamage() >= 80) {
            value += rand.nextInt(15) + 10;
        } else if (getDamage() >= 50) {
            value += rand.nextInt(10) + 5;
        }

        return value;
    }

    public boolean canEngineStayOn() {
        if (isInWater()) {
            addDamage(25);
            return false;
        }
        if (isInLava()) {
            return false;
        }

        if (getDamage() >= 100) {
            return false;
        }

        return super.canEngineStayOn();
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(DAMAGE, 0F);
    }

    public void setDamage(float damage) {
        if (damage > 100F) {
            damage = 100F;
        } else if (damage < 0) {
            damage = 0;
        }
        this.dataManager.set(DAMAGE, damage);
    }

    public float getDamage() {
        return this.dataManager.get(DAMAGE);
    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putFloat("damage", getDamage());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        setDamage(compound.getFloat("damage"));
    }

}
