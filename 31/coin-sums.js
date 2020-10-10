
const total = 200;
const coins = [1, 2, 5, 10, 20, 50, 100, 200];

console.log(allCombinations(total, 200).length);

function allCombinations(val, maxCoin) {
  const cmbs = [];

  for (let coin of coins) {
    if (coin <= maxCoin) {
      if (coin === val) {
        cmbs.push([coin]);
      } else if (coin < val) {
        const subCmbs = allCombinations(val - coin, coin);
        for (let subCmb of subCmbs) {
          cmbs.push([coin, ...subCmb]);
        }
      }
    }
  }

  return cmbs;
}
