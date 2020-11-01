package userModel;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class barchart {

 public  void fileOut(){

System.out.println("テスト１");


FileOutputStream fos = null;



try {

    // 日本語が文字化けしないテーマ

    ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());

    // グラフデータを設定する

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    dataset.addValue(50, "算数", "minato");

    dataset.addValue(60, "国語", "minato");

    dataset.addValue(70, "社会", "minato");

    dataset.addValue(70, "理科", "minato");

   dataset.addValue(80, "算数", "maki");

    dataset.addValue(90, "国語", "maki");

    dataset.addValue(100, "社会", "maki");

    dataset.addValue(70, "理科", "maki");

    dataset.addValue(90, "算数", "rei");

    dataset.addValue(80, "国語", "rei");

    dataset.addValue(70, "社会", "rei");

    dataset.addValue(70, "理科", "rei");

    System.out.println("テスト２");



    // グラフを生成する

    JFreeChart chart = ChartFactory.createBarChart("成績表", "科目", "点数", dataset, PlotOrientation.VERTICAL, true, false, false);

    System.out.println("テスト3");

   // 背景色を設定

    chart.setBackgroundPaint(ChartColor.WHITE);

    System.out.println("テスト4");
    // ファイルへ出力する
    fos = new FileOutputStream("C:\\workspace\\Quiz\\WebContent\\img\\score.jpg");

    String path = new File(".").getAbsoluteFile().getParent();
    System.out.println(path);

    ChartUtilities.writeChartAsJPEG(fos, chart, 600, 400);

    System.out.println("テスト5");

} catch (IOException e) {
	e.printStackTrace();


    // エラー処理

} finally {

//    IOUtils.closeQuetly(fos);

}
}
}