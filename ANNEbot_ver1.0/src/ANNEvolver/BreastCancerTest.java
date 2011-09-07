/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ANNEvolver;

import ANN.ANN;
import Utility.DataLogger;

/**
 *
 * @author Dilmi
 */
public class BreastCancerTest {
    private String dataFolder = System.getProperty("user.home") + "\\ANNEbot_Devel\\annebot\\Data\\";
       
    public void test(ANN ann){
       
        double score = 0;        
        double[][] input = this.getInput(dataFolder + "BreastCancerTesting.txt");
        double[] output;
        for (int i = 0; i < input.length; i++) {
            output = ann.produceOutput(input[i]);
            score = score + this.getFitness(output, input[i][0]);
        }
        System.out.println("Testing Score : " +score / input.length * 100);
         
    }
    
    public void test(){
       ANN ann = this.retrieveANN(dataFolder+"bestANN.dat");
        double score = 0;        
        double[][] input = this.getInput(dataFolder + "BreastCancerTesting.txt");
        double[] output;
        for (int i = 0; i < input.length; i++) {
            output = ann.produceOutput(input[i]);
            score = score + this.getFitness(output, input[i][0]);
        }
        System.out.println("Testing Score : " +score / input.length * 100);
         
    }

     public double getFitness(double output[], double cancerType){
        double fitness = 0;
        double max = output[0];
        int maxIndex = 0;        
        for(int i = 1 ; i < output.length;i++){
                int comparor = Double.compare(max,output[i]);

                if(comparor>0){
                   
                }
                else if(comparor<0){
                    max = output[i];
                    maxIndex = i;
                }
            

        }
        if((maxIndex+1)==cancerType){fitness=1;}        
        return fitness;
    }
    
    public ANN retrieveANN(String path){
        ANN ann = DataLogger.readANNObjectFromFile(path);
        return ann;
    }
    
    double[][] getInput(String filePath){
        String [][]stringInput = Utility.DataSetReader.readDataSet(filePath, 31 , "," );
        double [][] doubleInput = new double [stringInput.length][stringInput[0].length];
        for(int i  = 0 ; i < doubleInput.length ; i++){
            for(int j  = 0 ; j < doubleInput[i].length; j++){
                doubleInput[i][j] = Double.valueOf(stringInput[i][j]);                   
            }
        }
        
        return doubleInput;
    }

}
