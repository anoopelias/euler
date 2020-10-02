

print("sundays count")

days_of_month = {
        1: 31,
        2: 28,
        3: 31,
        4: 30,
        5: 31,
        6: 30,
        7: 31,
        8: 31,
        9: 30,
        10:31,
        11:30,
        12:31
        }

def is_leap_year(year):
    return (year % 4 == 0) and ((year % 100 != 0) or (year % 400 == 0))

def days_in_month(year, mo):
    if mo == 2 and is_leap_year(year):
        return 29
    return days_of_month.get(mo)


sundays = 0
day_of_week = 1

for year in range(1901, 2001):
    for month in range(1, 13):
        days = days_in_month(year, month)
        for day in range(days):
            if day_of_week == 7:
                day_of_week = 1
            else:
                day_of_week = day_of_week + 1

            if day_of_week == 7 and day == 1:
                sundays = sundays + 1

print(sundays)





