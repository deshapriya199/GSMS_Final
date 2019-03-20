/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meter;

import java.awt.Color;
import java.awt.Font;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.DialBackground;
import org.jfree.chart.plot.dial.DialLayer;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.DialPointer;
import org.jfree.chart.plot.dial.DialTextAnnotation;
import org.jfree.chart.plot.dial.DialValueIndicator;
import org.jfree.chart.plot.dial.StandardDialFrame;
import org.jfree.chart.plot.dial.StandardDialRange;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultValueDataset;

/**
 *
 * @author san
 */
public class MeterView {

    private int minimumValue;
    private int maximumValue;
    private int majorTickGap;
    private DialPlot plot;
    private Double green;
    private Double orange;
    private Double red;
    private String text;

    public MeterView(int minimumValue, int maximumValue, int majorTickGap, Double green, Double orange, Double red,String text) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        this.majorTickGap = majorTickGap;
        this.plot = plot;
        this.green = green;
        this.orange = orange;
        this.red = red;
        this.text=text;
    }

    public ChartPanel buildDialPlot() {
        plot = new DialPlot(new DefaultValueDataset(100));
        plot.setDialFrame(new StandardDialFrame());
        plot.addLayer(new DialValueIndicator(0));
        plot.addLayer(new DialPointer.Pointer());
        DialTextAnnotation dialtextannotation = new DialTextAnnotation(text);
        dialtextannotation.setFont(new Font("Dialog", 1, 14));
        dialtextannotation.setRadius(0.69999999999999996D);
        plot.addLayer(dialtextannotation);

        StandardDialScale scale = new StandardDialScale(minimumValue, maximumValue,
                -120, -300, majorTickGap, majorTickGap - 1);
        scale.setTickRadius(0.88);
        scale.setTickLabelOffset(0.20);
        plot.addScale(0, scale);
        plot.setBackground(new DialBackground(Color.WHITE));        

        StandardDialRange standarddialrange = new StandardDialRange(orange, red, Color.red);
        standarddialrange.setInnerRadius(0.52000000000000002D);
        standarddialrange.setOuterRadius(0.55000000000000004D);
        plot.addLayer(standarddialrange);
        StandardDialRange standarddialrange1 = new StandardDialRange(green, orange, Color.orange);
        standarddialrange1.setInnerRadius(0.52000000000000002D);
        standarddialrange1.setOuterRadius(0.55000000000000004D);
        plot.addLayer(standarddialrange1);
        StandardDialRange standarddialrange2 = new StandardDialRange(0D, green, Color.green);
        standarddialrange2.setInnerRadius(0.52000000000000002D);
        standarddialrange2.setOuterRadius(0.55000000000000004D);
        plot.addLayer(standarddialrange2);
        JFreeChart jFreeChart = new JFreeChart(plot);
        jFreeChart.setBackgroundPaint(Color.WHITE);
        return new ChartPanel(jFreeChart);
    }

    public void setVal(int val) {
        plot.setDataset(new DefaultValueDataset(val));
    }

}
