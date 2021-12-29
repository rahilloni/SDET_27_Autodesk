package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest {
	
	
	@Test(dataProvider = "getData")
	public void readDataProviderTest(String BikeName, int cc, int mileage)
	{
		
		System.out.println("Bike Name->"+BikeName+"     CC-->"+cc+"    Mileage--->"+mileage);
	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[5][3];
		
		objArr[0][0]="Pulsar";
		objArr[0][1]=200;
		objArr[0][2]=25;
		
		objArr[1][0]="Kawasaki";
		objArr[1][1]=800;
		objArr[1][2]=12;
		
		objArr[2][0]="Benelli";
		objArr[2][1]=600;
		objArr[2][2]=20;
		
		objArr[3][0]="Triumph";
		objArr[3][1]=250;
		objArr[3][2]=25;
		
		objArr[4][0]="Harley Davidson";
		objArr[4][1]=1200;
		objArr[4][2]=10;
		
		
		return objArr;
	}

}
