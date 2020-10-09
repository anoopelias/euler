const POW: u32 = 5;

fn main() {
    let mut sum = 0;
    for n in 2..10000000 {
        if n == sum_of_pow(n) {
            sum = sum + n;
            println!("{}", n);
        }
    }
    println!("{}", sum);
}

fn sum_of_pow(n: i32) -> i32 {
    get_digits(n).iter().map(|x| x.pow(POW)).sum::<i32>()
}

fn get_digits(n: i32) -> Vec<i32> {
    let mut digits = Vec::new();
    let mut m = n;
    while m != 0 {
        digits.push(m % 10);
        m = m / 10;
    }

    return digits;
}
