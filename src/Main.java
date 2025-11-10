import entities.Weapon;
import factory.WeaponFactory;
import game.GameManager;
import game.TurnHandler;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();
        TurnHandler turnHandler = new TurnHandler();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Zumbi Royale ===");
        System.out.println("Regras do jogo:");
        System.out.println("- Você enfrenta um zumbi com 100 pontos de vida.");
        System.out.println("- Você começa saudável e pode ficar ferido ou infectado se tomar dano.");
        System.out.println("- Ações disponíveis:");
        System.out.println("  [1] Atacar: Escolha uma arma (Pistola, Escopeta, Machado).");
        System.out.println("      - Se acertar: Zumbi perde vida, mas pode contra-atacar com 50% de chance.");
        System.out.println("      - Se errar: Zumbi contra-ataca com 100% de chance.");
        System.out.println("  [2] Fugir: Reduz a chance de contra-ataque do zumbi para 20% no próximo turno.");
        System.out.println("  [3] Curar: Se estiver ferido, 60% de chance de voltar a saudável.");
        System.out.println("- Se você ficar infectado, perde o jogo. Se matar o zumbi, vence!");
        System.out.println("Armas disponíveis: Pistola, Escopeta, Machado");
        System.out.println("Boa sorte!\n");

        while (!gameManager.isGameOver()) {
            System.out.println("\nEscolha sua ação: [1] Atacar [2] Fugir [3] Curar");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Escolha a arma: Pistola / Escopeta / Machado");
                    String weaponChoice = scanner.nextLine();
                    Weapon weapon = WeaponFactory.createWeapon(weaponChoice);
                    turnHandler.attack(weapon);
                    break;
                case "2":
                    turnHandler.flee();
                    break;
                case "3":
                    turnHandler.heal();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        System.out.println("Fim do jogo!");
        scanner.close();
    }
}
