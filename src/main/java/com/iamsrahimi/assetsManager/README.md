# Assets Manager

A beginner-friendly Java 17 console application demonstrating inheritance,
method overriding, polymorphism, `ArrayList<Asset>`, and `instanceof` downcasting.
This is a simplified academic example and is not a real appraisal tool.

## Files

- `Asset.java` — shared description, acquisition date, original cost, and base value
- `House.java` — house details and square-foot based estimated value
- `Vehicle.java` — vehicle details, age-based depreciation, and mileage adjustment
- `AssetsManager.java` — sample assets and formatted output

## Run

Open a terminal in this folder and run:

```bash
javac *.java
java AssetsManager
```

The vehicle age is calculated using the current calendar year. For vehicles up to
10 years old, the yearly percentage is applied to the original cost using simple
depreciation. Vehicles over 10 years old start at $1,000.00. The 25% mileage
reduction applies when the odometer is over 100,000 miles, except for Honda and
Toyota models.
