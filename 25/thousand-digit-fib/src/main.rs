use num_bigint::BigUint;
use num_traits::{Zero, One};
use std::mem::replace;

fn main() {
    println!("i = {}", fib(1000));
}

// See https://docs.rs/num-bigint/0.3.0/num_bigint/
fn fib(n: usize) -> i32 {
    let mut f0: BigUint = Zero::zero();
    let mut f1: BigUint = One::one();
    let mut i = 0;
    while f0.to_str_radix(10).chars().count() < n {
        let f2 = f0 + &f1;
        // This is a low cost way of swapping f0 with f1 and f1 with f2.
        f0 = replace(&mut f1, f2);
        i = i + 1;
    }
    i
}
