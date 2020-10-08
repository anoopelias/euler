fn main() {
    let mut m = 0;
    let mut cnt = 0;
    for n in 1..1000 {
        let ncnt = fractional(n);
        if ncnt > cnt {
            cnt = ncnt;
            m = n;
        }
    }
    println!("n:{} cnt:{}", m, cnt);
}

fn fractional(n: i32) -> i32 {
    let mut rem = 10;
    let mut rems = vec![10];
    let mut repeating = false;
    let mut i = 0;

    print!("{} : ", n);
    while !repeating {
        print!("{}", rem / n);
        rem = (rem % n) * 10;
        i = 0;

        if rem == 0 {
            repeating = true;
        } else {
            for old_rem in rems.iter().rev() {
                i = i + 1;
                if *old_rem == rem {
                    repeating = true;
                    break;
                }
            }
            rems.push(rem);
        }

    }
    println!(" :{}", i);

    return i;
}
