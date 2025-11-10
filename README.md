# Zumbi Royale

## 📌 Descrição
Jogo de turnos em Java onde o jogador enfrenta um zumbi com 100 pontos de vida. O jogador pode atacar, fugir ou se curar, usando armas com diferentes danos e precisões. Implementa os padrões de projeto: **Factory**, **Singleton**, **Strategy** e **State**.

## 🎮 Regras do Jogo
- O jogador começa saudável e pode ficar ferido ou infectado se tomar dano.
- Ações:
  - **Atacar:** Escolha uma arma. Se acertar, zumbi perde vida, mas pode contra-atacar com 50% de chance. Se errar, zumbi contra-ataca com 100%.
  - **Fugir:** Reduz a chance de contra-ataque para 20% no próximo turno.
  - **Curar:** Se estiver ferido, 60% de chance de voltar a saudável.
- Se você ficar infectado, perde. Se matar o zumbi, vence.
