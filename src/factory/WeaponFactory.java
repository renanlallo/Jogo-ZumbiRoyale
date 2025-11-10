package factory;

import entities.Weapon;

public class WeaponFactory {

    public static Weapon createWeapon(String type) {
        switch (type.toLowerCase()) {
            case "pistola":
                return new Weapon("Pistola", 15, 0.8);
            case "escopeta":
                return new Weapon("Escopeta", 30, 0.6);
            case "machado":
                return new Weapon("Machado", 50, 0.4);
            default:
                throw new IllegalArgumentException("Tipo de arma inválido: " + type);
        }
    }
}