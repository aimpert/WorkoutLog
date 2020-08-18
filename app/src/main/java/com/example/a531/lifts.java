package com.example.a531;

public class lifts {
    float deadlift;
    float squat;
    float bench_press;
    float ohp;

    public lifts(float deadlift,
            float squat,
            float bench_press,
            float ohp)
    {
        this.deadlift = 0;
        this.squat = 0;
        this.bench_press = 0;
        this.ohp = 0;
    }

    public float get_deadlift()
    {
        return deadlift;
    }

    public double get_deadliftTM()
    {
        return (0.90 * deadlift);
    }

    public float get_squat()
    {
        return deadlift;
    }

    public double get_squatTM()
    {
        return (0.90 * squat);
    }

    public float get_bench_press()
    {
        return deadlift;
    }

    public double get_BPTM()
    {
        return (0.90 * bench_press);
    }


    public float get_ohp()
    {
        return ohp;
    }

    public double get_ohpTM() {
        return (0.90 * ohp);}

    public void set_deadlift(float newDL) {
        this.deadlift = newDL;
    }


    public void set_squat(float newSquat) {
        this.squat = newSquat;
    }


    public void set_bench_press(float newBP) {
        this.bench_press = newBP;
    }


    public void set_OHP(float newOHP) {
        this.ohp = newOHP;
    }
}
