const solution = (coin, cards = []) => {
  // 초기 셋팅
  let currCard = cards.slice(0, cards.length / 3);
  let leftCard = cards.slice(cards.length / 3);

  let matching = onFind(currCard, cards.length + 1);

  let round = 0;
  let keep = [];

  while (true) {
    round++;

    if (leftCard.length < 2) break;

    keep = [...keep, leftCard.shift(), leftCard.shift()];

    if (matching.length !== 0) {
      currCard = onFilterByCard(currCard, matching.shift());
    } else {
      if (coin < 1) break;

      const oneCoin = onFindByAdd(currCard, keep, cards.length + 1);

      if (oneCoin.length === 0) {
        if (coin < 2) break;

        const twoCoin = onFindByAdd(keep, keep, cards.length + 1);
        if (twoCoin.length === 0) break;

        keep = onFilterByCard(keep, twoCoin);
        coin -= 2;
      } else {
        currCard = onFilterByCard(currCard, oneCoin);
        keep = onFilterByCard(keep, oneCoin);
        coin--;
      }
    }
  }

  console.log(round);

  return round;
};

// 해당하는 카드값 중 포합되어 있는 숫자가 있는 카드값 제거
const onFilterByCard = (card, target) => {
  return card.filter((key) => !(key === target[0] || key === target[1]));
};

// 카드 추가되었을 경우 매칭 추가
const onFindByAdd = (card = [], next = [], target) => {
  let result = [];

  for (let i = 0; i < card.length; i++) {
    for (let j = 0; j < next.length; j++) {
      if (card[i] + next[j] === target) return [card[i], next[j]];
    }
  }

  return result;
};

// 처음 카드 매칭
const onFind = (cards = [], target) => {
  let result = [];

  for (let i = 0; i < cards.length; i++) {
    for (let j = i + 1; j < cards.length; j++) {
      if (cards[i] + cards[j] === target)
        result = [...result, [cards[i], cards[j]]];
    }
  }

  return result;
};

solution(4, [3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4]);
solution(3, [1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12]);
solution(2, [5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7]);
solution(10, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]);
