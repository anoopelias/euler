
console.log('Integer right triangles');

function solutions(p) {
  let n = 0;
  for (let i=1; i<p; i++) {
    for (let j=i; j<p; j++) {
      for (let k=j; k<p; k++) {
        if (i + j + k === p) {
          if (isRightTriangle(i, j, k)) {
            n++;
          }
        }
      }
    }
  }

  return n;
}

function isRightTriangle(i, j, k) {
  const kRight = Math.sqrt((i*i) + (j*j));
  return Number.isInteger(kRight) && kRight === k;
}

let maxN = -1;
let maxP = 0;
for (let p=1; p<1000; p++) {
  const n = solutions(p);
  if (n > maxN) {
    maxN = n;
    maxP = p;
  }
}

console.log(maxP, maxN);
