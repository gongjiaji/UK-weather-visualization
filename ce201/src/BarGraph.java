package ce201.src;

import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BarGraph extends JDialog{

 public ArrayList<String> dataSet;

    public BarGraph(String title, String xTitle, String yTitle) {

        dataSet = PostDataSnippet.snippedData;

        JFreeChart jFreeChart = ChartFactory.createBarChart(title, xTitle, yTitle, createDataset(),
                PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jFreeChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth() - 100;
        int height = (int) screenSize.getHeight() - 100;


        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        this.add(chartPanel);
        this.setSize(width, height);
        this.setModal(true);

        File BarGraph = new File("BarGraph.jpeg");
        try {
            ChartUtilities.saveChartAsJPEG(BarGraph, jFreeChart, 600, 450);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String[] types = {"id", "timestamp", "demand", "frequency", "coal", "nuclear", "cgt", "wind",
                "french_ict", "dutch_ict", "irish_ict", "ew_ict", "pumped", "hydro", "oil", "ocgt", "other", "solar"};

        for (String x : dataSet) {
            String[] dataA = x.split(",");
            for (int i = 4; i < dataA.length; i++) {

                try {
                    dataset.addValue(Integer.parseInt(dataA[i].trim()), types[i], dataA[1]);
                } catch (NumberFormatException e) {
                    dataset.addValue(Double.parseDouble(dataA[i].trim()), types[i], dataA[1]);
                }
            }
        }

        return dataset;
    }

}
