package com.wl.structure.adapter;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.02$
 * @Param 适配器——测试$
 * @return $
 */
public class Demo {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        if (hole.fits(roundPeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }
        SquarePeg smallSquarePeg = new SquarePeg(2);
        SquarePeg largeSquarePeg = new SquarePeg(20);
        Adapter smallAdapter = new Adapter(smallSquarePeg);
        Adapter largeAdapter = new Adapter(largeSquarePeg);
        if (hole.fits(smallAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeAdapter)){
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }
    }
}
