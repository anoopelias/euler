function factorsOf(num) {
  const factors = [];
  for(let i=1; i<num; i++) {
    if (num%i==0) {
      factors.push(i);
    }
  }
  return factors;
}

function sumOfFactors(num) {
  return factorsOf(num)
          .reduce((a, b) => a + b, 0);
}

function isAmicable(num) {
  const pair = sumOfFactors(num);
  return pair != num && sumOfFactors(pair) === num;
}

console.log([...Array(9999).keys()]
   .map(n => n + 1) // we need 1..(n-1)
   .filter(isAmicable)
   .reduce((a, b) => a + b));
