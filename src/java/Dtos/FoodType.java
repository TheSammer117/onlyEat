/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author 82509
 */
public class FoodType {

    private int typeId;
    private String name;
    private String description;

    public FoodType(int typeId, String name, String description) {
        this.typeId = typeId;
        this.name = name;
        this.description = description;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.typeId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FoodType other = (FoodType) obj;
        if (this.typeId != other.typeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FoodType{" + "typeId=" + typeId + ", name=" + name + ", description=" + description + '}';
    }

}
