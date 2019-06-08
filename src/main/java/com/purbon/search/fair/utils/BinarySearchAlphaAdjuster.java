package com.purbon.search.fair.utils;

public class BinarySearchAlphaAdjuster {


    private int k;
    private double p;
    private double alpha;
    private double adjustedAlpha;
    private static final double STEP = 0.000001;


    public BinarySearchAlphaAdjuster(int k, double p, double alpha) {
        if (k < 20) {
            throw new IllegalArgumentException("Parameter k must be at least 20 to be adjusted");
        }
        if (p <= 0.0 || p >= 1.0) {
            throw new IllegalArgumentException("Parameter p must be in ]0.0, 1.0[");
        }
        if (alpha <= 0d || alpha >= 1.0) {
            throw new IllegalArgumentException("Parameter alpha must be in ]0.0, 1.0[");
        }
        this.k = k;
        this.p = p;
        if (alpha < 0.001) {
            throw new IllegalArgumentException("Alpha has to be greater than or equal to 0.001 for an adjustment.");
        }
        this.alpha = alpha;
    }

    public double adjustAlpha() {
        if (this.k <= 40 && this.k>=20) {
            this.adjustedAlpha = adjustFlatSearch();
            return adjustedAlpha;
        } else {
            this.adjustedAlpha = adjustIterative();
            return adjustedAlpha;
        }
    }

    /**
     * Searches iterative a better alpha bye trying smaller alphas step by step. The step size equals 1/500 of the initial alpha.
     * @return the alpha with the least distance from the desired failure probability found by the steps
     */
    private double adjustFlatSearch() {
        AlphaAdjuster minAdjuster = new AlphaAdjuster(k, p, alpha);
        double min = minAdjuster.computeFailureProbability();
        double minAlpha = alpha;
        int steps = 500;
        double stepSize = alpha / steps;
        for (int i = 0; i < steps; i++) {
            double adjustedAlpha = alpha - (i * stepSize);
            AlphaAdjuster adjuster = new AlphaAdjuster(k, p, adjustedAlpha);
            double currentSuccessProb = adjuster.computeFailureProbability();
            if (Math.abs(currentSuccessProb - alpha) < Math.abs(min - alpha)) {
                min = currentSuccessProb;
                minAlpha = adjustedAlpha;
            }
        }
        return minAlpha;
    }


    /**
     * Searches binary and iterative for the right failure probability
     * @return the adjusted alpha
     */
    private double adjustIterative() {
        double adjustedAlpha;
        double left = Double.MIN_VALUE;
        double right = alpha;
        double minOptAlpha = (left + right) / 2.0;

        while (left <= right) {
            adjustedAlpha = (left + right) / 2.0;
            AlphaAdjuster adjuster = new AlphaAdjuster(k, p, adjustedAlpha);
            double succProb = adjuster.computeFailureProbability();
            if (Math.abs(succProb - alpha) <= 0.0001) {
                return adjustedAlpha;
            } else if (Math.abs(succProb - alpha) < Math.abs(succProb - minOptAlpha)) {
                minOptAlpha = adjustedAlpha;
            }
            if (alpha < succProb) {
                right = adjustedAlpha - STEP;
            } else {
                left = adjustedAlpha + STEP;
            }

        }
        return minOptAlpha;
    }

    public int getK() {
        return k;
    }

    public double getP() {
        return p;
    }

    public double getAlpha() {
        return alpha;
    }

    public double getAdjustedAlpha() {
            return adjustedAlpha;
    }
}
