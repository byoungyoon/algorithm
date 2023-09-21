const solution = (players, callings) => {
  let rank = {};

  for (let i = 0; i < players.length; i++) {
    rank[players[i]] = i;
  }

  callings.forEach((calling) => {
    const callingRank = rank[calling];

    const target = players[callingRank - 1];
    const targetRank = rank[target];

    rank[target] = callingRank;
    rank[calling] = targetRank;

    players[callingRank] = target;
    players[targetRank] = calling;
  });

  let result = [];

  Object.keys(rank).forEach((key) => {
    result[rank[key]] = key;
  });

  return result;
};

console.log(
  solution(
    ["mumu", "soe", "poe", "kai", "mine"],
    ["kai", "kai", "mine", "mine"]
  )
);
