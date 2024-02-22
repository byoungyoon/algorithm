function solution(number, limit, power) {
  let result = 0;

  for (let i = 1; i <= number; i++) {
    let sum = 1;

    for (let j = 1; j <= i / 2; j++) {
      if (i % j === 0) {
        sum++;

        if (sum > limit) {
          sum = power;
          break;
        }
      }
    }

    result += sum;
  }

  return result;
}