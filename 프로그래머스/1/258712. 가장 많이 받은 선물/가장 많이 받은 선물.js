function solution(friends, gifts) {
  const detail = Object.assign(
    {},
    ...friends.map((key) => ({
      [key]: Object.assign(
        {},
        ...friends.map((key2) => ({
          [key2]: 0,
        }))
      ),
    }))
  );

  const total = Object.assign(
    {},
    ...friends.map((key) => ({
      [key]: {
        give: 0,
        recive: 0,
      },
    }))
  );

  const answer = Object.assign({}, ...friends.map((key) => ({ [key]: 0 })));

  gifts.forEach((key) => {
    const split = key.split(" ");

    detail[split[0]][split[1]]++;
    total[split[0]].give++;
    total[split[1]].recive++;
  });

  Object.keys(detail).forEach((friend) => {
    Object.keys(detail[friend]).forEach((friend2) => {
      if (detail[friend][friend2] === detail[friend2][friend]) {
        const value1 = total[friend].give - total[friend].recive;
        const value2 = total[friend2].give - total[friend2].recive;

        if (value1 > value2) {
          answer[friend]++;
        } else if (value1 < value2) {
          answer[friend2]++;
        }
      } else if (
        detail[friend][friend2] !== 0 ||
        detail[friend2][friend] !== 0
      ) {
        if (detail[friend][friend2] > detail[friend2][friend]) {
          answer[friend]++;
        } else {
          answer[friend2]++;
        }
      }
    });
  });

  return Math.max(...Object.values(answer)) / 2;
}