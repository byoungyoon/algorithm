const solution = (bandage, health, attacks = []) => {
  const maxHealth = health;
  let time = 0;

  for (let i = 0; i < attacks.length; i++) {
    const timed = attacks[i][0] - time - 1;

    health += timed * bandage[1];
    if (timed >= bandage[0])
      health += Math.floor(timed / bandage[0]) * bandage[2];

    health = Math.min(maxHealth, health);

    health -= attacks[i][1];
    time = attacks[i][0];

    if (health <= 0) {
      return -1;
    }
  }

  return health;
};

console.log(
  solution([5, 1, 5], 30, [
    [2, 10],
    [9, 15],
    [10, 5],
    [11, 5],
  ])
);

console.log(solution([3, 2, 7], 20, [[1, 15], [5, 16], [8, 6], ,]));

console.log(
  solution([4, 2, 7], 20, [
    [1, 15],
    [5, 16],
    [8, 6],
  ])
);

console.log(
  solution([1, 1, 1], 5, [
    [1, 2],
    [3, 2],
  ])
);
