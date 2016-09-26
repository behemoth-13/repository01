package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Alex on 26.03.2016.
 */
public class SubSolution extends Solution
{

        private SubSolution(int x){super(x);}
        private SubSolution(int x, int y){super(x,y);}
        private SubSolution(int x, int y, int z){super(x, y, z);}
        SubSolution(double x)  { super(x);   }
        SubSolution(double x, double y) {super(x, y); }
        SubSolution(double x, double y, double z){super(x, y, z);}
        protected SubSolution(float x){super(x); }
        protected SubSolution(float x, float y){super(x, y);}
        protected SubSolution(float x, float y, float z) { super(x, y, z); }
        public SubSolution(long x){ super(x); }
        public SubSolution(long x, long y) { super(x, y); }
        public SubSolution(long x, long y, long z) { super(x, y, z);}
    }

