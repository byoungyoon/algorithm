const solution = (k, m, score) => {
  const arr = [];

  score.forEach((value) => {
    arr[value] = (arr[value] ?? 0) + 1;
  });

  let result = 0;
  let outer = 0;
  for (let i = k; i >= 1; i--) {
    const count = (arr[i] ?? 0) + outer;

    const temp = Math.floor(count / m);
    result += i * m * temp;

    outer = count - temp * m;
  }

  return result;
};

console.log(solution(3, 4, [1, 2, 3, 1, 2, 3, 1]));
console.log(solution(4, 3, [4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]));
