const solution = (coin, cards) => {
  const currCard = cards.slice(0, cards.length / 3);

  // 초기셋팅(처음 가진 카드, 남은 카드, 남은 코인 ...)
  let queue = [
    {
      currCard: currCard,
      leftCard: cards.slice(cards.length / 3),
      coin,
      round: 1,
      matching: onFind(currCard, cards.length + 1),
    },
  ];

  let max = 0;

  // 라운드 시작
  while (queue.length !== 0) {
    // 카드 새로 뽑기, 카드 뽑는 방향성에 따라 분기점 생성
    const curr = queue.shift();
    max = Math.max(max, curr.round);

    // 1) 카드 다 버림
    if (curr.matching.length !== 0) {
      const next = {
        currCard: onFilterByCard(curr.currCard, curr.matching[0]),
        leftCard: curr.leftCard.slice(2),
        coin: curr.coin,
        round: curr.round + 1,
        matching: curr.matching.slice(1),
      };

      queue.push(next);
    }
    // 2) 카드 한장만 버림
    if (curr.coin >= 1 && curr.leftCard.length >= 1) {
      for (let i = 0; i < 2; i++) {
        const nextCard = [...curr.currCard, curr.leftCard[i]];
        const nextMatching = [
          ...curr.matching,
          ...onFindByAdd(curr.currCard, [curr.leftCard[i]], cards.length + 1),
        ];

        if (nextMatching.length !== 0) {
          const next = {
            currCard: onFilterByCard(nextCard, nextMatching[0]),
            leftCard: curr.leftCard.slice(2),
            coin: curr.coin - 1,
            round: curr.round + 1,
            matching: nextMatching.slice(1),
          };

          queue.push(next);
        }
      }
    }

    // 3) 카드 두장다 가짐
    if (curr.coin >= 2 && curr.leftCard.length >= 2) {
      const nextCard = [...curr.currCard, curr.leftCard[0], curr.leftCard[1]];
      const nextMatching = [
        ...curr.matching,
        ...onFindByAdd(
          curr.currCard,
          [curr.leftCard[0], curr.leftCard[1]],
          cards.length + 1
        ),
      ];

      if (nextMatching.length !== 0) {
        const next = {
          currCard: onFilterByCard(nextCard, nextMatching[0]),
          leftCard: curr.leftCard.slice(2),
          coin: curr.coin - 2,
          round: curr.round + 1,
          matching: nextMatching.slice(1),
        };

        queue.push(next);
      }
    }
  }

  return max;
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
      if (card[i] + next[j] === target)
        result = [...result, [card[i], next[j]]];
    }
  }

  if (next.length === 2 && next[0] + next[1] === target)
    result = [...result, [next[0], next[1]]];

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
