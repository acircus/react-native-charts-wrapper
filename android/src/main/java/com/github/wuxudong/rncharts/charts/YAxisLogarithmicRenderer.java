package com.github.wuxudong.rncharts.charts;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

class YAxisLogarithmicRenderer extends YAxisRenderer {

    YAxisLogarithmicRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer trans){
        super(viewPortHandler, yAxis, trans);

        yAxis.setLabelCount(7, true);
        yAxis.mEntryCount= 7;
        yAxis.setAxisMinimum(0);
        yAxis.setAxisMaximum((float) logarithm(100, 2)+1);
        yAxis.setInverted(true);

        final DecimalFormat format = new DecimalFormat("##");
        yAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return format.format(Math.pow(2, value - 1));
            }
        });
    }

    @Override
    protected void computeAxisValues(float min, float max) {
//        super.computeAxisValues(min, max);

        this.mYAxis.mEntries = new float[7];

        this.mYAxis.mEntries[0] = (float) (logarithm(1,2)+1);
        this.mYAxis.mEntries[1] = (float) (logarithm(2,2)+1);
        this.mYAxis.mEntries[2] = (float) (logarithm(4,2)+1);
        this.mYAxis.mEntries[3] = (float) (logarithm(10,2)+1);
        this.mYAxis.mEntries[4] = (float) (logarithm(20,2)+1);
        this.mYAxis.mEntries[5] = (float) (logarithm(40,2)+1);
        this.mYAxis.mEntries[6] = (float) (logarithm(100,2)+1);
    }

    public static double logarithm(double x, double base)
    {
        return (Math.log(x) / Math.log(base));
    }
}
