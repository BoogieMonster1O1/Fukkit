package org.bukkit.craftbukkit.entity;

import net.minecraft.entity.vehicle.BoatEntity;
import org.bukkit.TreeSpecies;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;

public class CraftBoat extends CraftVehicle implements Boat {

    public CraftBoat(CraftServer server, BoatEntity entity) {
        super(server, entity);
    }

    @Override
    public TreeSpecies getWoodType() {
        return getTreeSpecies(getHandle().getBoatType());
    }

    @Override
    public void setWoodType(TreeSpecies species) {
        getHandle().setBoatType(getBoatType(species));
    }

    @Override
    public double getMaxSpeed() {
        return getHandle().maxSpeed;
    }

    @Override
    public void setMaxSpeed(double speed) {
        if (speed >= 0D) {
            getHandle().maxSpeed = speed;
        }
    }

    @Override
    public double getOccupiedDeceleration() {
        return getHandle().occupiedDeceleration;
    }

    @Override
    public void setOccupiedDeceleration(double speed) {
        if (speed >= 0D) {
            getHandle().occupiedDeceleration = speed;
        }
    }

    @Override
    public double getUnoccupiedDeceleration() {
        return getHandle().unoccupiedDeceleration;
    }

    @Override
    public void setUnoccupiedDeceleration(double speed) {
        getHandle().unoccupiedDeceleration = speed;
    }

    @Override
    public boolean getWorkOnLand() {
        return getHandle().landBoats;
    }

    @Override
    public void setWorkOnLand(boolean workOnLand) {
        getHandle().landBoats = workOnLand;
    }

    @Override
    public BoatEntity getHandle() {
        return (BoatEntity) entity;
    }

    @Override
    public String toString() {
        return "CraftBoat";
    }

    @Override
    public EntityType getType() {
        return EntityType.BOAT;
    }

    public static TreeSpecies getTreeSpecies(BoatEntity.b boatType) {
        switch (boatType) {
            case SPRUCE:
                return TreeSpecies.REDWOOD;
            case BIRCH:
                return TreeSpecies.BIRCH;
            case JUNGLE:
                return TreeSpecies.JUNGLE;
            case ACACIA:
                return TreeSpecies.ACACIA;
            case DARK_OAK:
                return TreeSpecies.DARK_OAK;
            case OAK:
            default:
                return TreeSpecies.GENERIC;
        }
    }

    public static BoatEntity.b getBoatType(TreeSpecies species) {
        switch (species) {
            case REDWOOD:
                return BoatEntity.b.SPRUCE;
            case BIRCH:
                return BoatEntity.b.BIRCH;
            case JUNGLE:
                return BoatEntity.b.JUNGLE;
            case ACACIA:
                return BoatEntity.b.ACACIA;
            case DARK_OAK:
                return BoatEntity.b.DARK_OAK;
            case GENERIC:
            default:
                return BoatEntity.b.OAK;
        }
    }
}
