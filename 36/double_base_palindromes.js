function toDigits(n, base) {
  let digits = [];

  while (n !== 0) {
    digits.unshift(n % base);
    n = Math.floor(n / base);
  }

  return digits;
}

function isPalindrome(arr) {
  const mid = Math.floor(arr.length / 2);

  for (let i = 0; i < mid; i++) {
    if (arr[i] != arr[arr.length - 1 - i]) {
      return false;
    }
  }

  return true;
}

const pals = [];
for (let i = 0; i < 1000000; i++) {
  if (isPalindrome(toDigits(i, 10)) && isPalindrome(toDigits(i, 2))) {
    pals.push(i);
  }
}

console.log(pals.reduce((a, b) => a + b));
