fn main() {
    for n in 2..1000000 {
        let mut circular_prime = true;
        let mut digits = to_digits(n);

        for _ in 0..digits.len() {
            digits = rotate(digits);
            let num = to_num(&digits);

            if !is_prime(num) {
                circular_prime = false;
                break;
            }
        }

        if circular_prime {
            println!("Circular Prime : {}", n);
        }
    }
}

fn rotate(digits: Vec<i64>) -> Vec<i64> {
    let mut rot_digits = Vec::new();

    for n in &digits[1..] {
        rot_digits.push(*n);
    }
    rot_digits.push(*digits.first().unwrap());

    rot_digits
}

fn to_num(digits: &Vec<i64>) -> i64 {
    let mut num = 0;
    for n in digits {
        num = (num * 10) + n;
    }

    num
}

fn to_digits(n: i64) -> Vec<i64> {
    let mut digits = Vec::new();
    let mut m = n;
    while m != 0 {
        digits.push(m % 10);
        m = m / 10;
    }

    digits.reverse();
    digits
}

fn is_prime(n: i64) -> bool {
    let sqrt = ((n as f32).sqrt()) as i64;

    for i in 2..(sqrt + 1) {
        if n % i == 0 {
            return false;
        }
    }
    true
}
