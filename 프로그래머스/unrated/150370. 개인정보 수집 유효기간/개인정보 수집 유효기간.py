def solution(today, terms, privacies):
    answer = []

    termsInfo = dict()

    for term in terms:
        term = term.split()
        termsInfo[term[0]] = int(term[1]) * 28

    localToday = makeDay(today)
    for i in range(len(privacies)):
        day, term = privacies[i].split()
        if localToday >= makeDay(day) + termsInfo[term]:
            answer.append(i + 1)

    return answer

def makeDay(date):
    year, month, day = map(int, date.split("."))

    return (year * 12 * 28) + (month * 28) + day