/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ANNEvolver;

import Utility.ANNConfiguration;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.DoubleGene;

/**
 *
 * @author sulantha
 */
public class WeightModifier {

    private String dataFolder = System.getProperty("user.home") + "\\ANNEbot_Devel\\ANNEbot_POC\\ANNEbot_POC\\Data\\";
    private int averageCount;
    private int maxEvolutionsAllowed;
    private double upperThreshold;
    private IChromosome bestChromosome = null;
    private double[] bestChromosomeFitnessArray = null;
    private double bestChromosomeScore;
    private double bestChromosomeTestScore;
    private double bestChromosomeValidationScore;
    private double bestChromosomeTrainingScore;
    private double weightForValidation = 0.33;
    private double weightForTraining = 0.33;
    private double weightForTesting = 0.33;

    public WeightModifier(int averageCount, int maxEvolutionsAllowed, double upperThreshold) {
        this.averageCount = averageCount;
        this.maxEvolutionsAllowed = maxEvolutionsAllowed;
        this.upperThreshold = upperThreshold;
    }

    public IChromosome getBestWeightChromosome(int chromosomeLength, int populationSize) throws InvalidConfigurationException, IOException {
        Configuration.reset();
        Configuration conf = new DefaultConfiguration();
        //FitnessFunction testFunc = new IrisFitnessFunction();


        //////////////////////////////Edit according to application//////////////////////
        FitnessFunction testFunc = new IrisFitnessFunction();
        IrisValidator validator = new IrisValidator();
        IrisTest tester = new IrisTest();
        //FitnessFunction testFunc = new BreastCancerFitnessFunction();
        //BreastCancerValidator validator = new BreastCancerValidator();
        //FitnessFunction testFunc = new ParkinsonsFitnessFunction();
        //ParkinsonsValidator validator = new ParkinsonsValidator();
        /////////////////////////////////////////////////////////////////////////////////


        conf.setFitnessFunction(testFunc);

        Gene[] sampleGenes = new Gene[chromosomeLength];
        for (int i = 0; i < chromosomeLength; i++) {
            sampleGenes[i] = new DoubleGene(conf, -10.0, 10.0);
        }
        Chromosome sampleChromosome = new Chromosome(conf, sampleGenes);
        conf.setSampleChromosome(sampleChromosome);
        conf.setPopulationSize(populationSize);

        for (int i = 0; i < averageCount; i++) {
            double[] currentChromosomeFitnessArray = new double[maxEvolutionsAllowed + 2];
            currentChromosomeFitnessArray[0] = ANNConfiguration.hiddenLNeuronCountConfig;
            currentChromosomeFitnessArray[1] = chromosomeLength;
            Genotype population = Genotype.randomInitialGenotype(conf);
            int numOfEvolutionsToThresh = 0;
            for (int j = 0; j < maxEvolutionsAllowed; j++) {
                numOfEvolutionsToThresh = 0;
                population.evolve();
                double fitness = population.getFittestChromosome().getFitnessValue();
                currentChromosomeFitnessArray[j + 2] = fitness;
                if (fitness >= upperThreshold) {
                    numOfEvolutionsToThresh = j + 1;
                }
            }
            if (numOfEvolutionsToThresh == 0) {
                numOfEvolutionsToThresh = maxEvolutionsAllowed;
            }
            double finalFitness = population.getFittestChromosome().getFitnessValue();
            IChromosome bestChInCurrPop = population.getFittestChromosome();
            double score_validation = validator.getValidationScore(bestChInCurrPop);
            double score_training = bestChInCurrPop.getFitnessValue();
            double score_testing = tester.test(EvolverUtility.getANNfromChromosome(bestChInCurrPop));
            double score = score_validation * weightForValidation + score_training * weightForTraining + score_testing * weightForTesting;
            bestChInCurrPop.setFitnessValue(score);
            if (bestChromosome == null) {
                bestChromosome = bestChInCurrPop;
                bestChromosomeScore = score;
                bestChromosomeTestScore = score_testing;
                bestChromosomeValidationScore = score_validation;
                bestChromosomeTrainingScore = score_training;
                bestChromosomeFitnessArray = currentChromosomeFitnessArray;

            } else {
                if (bestChromosomeScore < score) {
                    bestChromosome = bestChInCurrPop;
                    bestChromosomeScore = score;
                    bestChromosomeTestScore = score_testing;
                    bestChromosomeValidationScore = score_validation;
                    bestChromosomeTrainingScore = score_training;
                    bestChromosomeFitnessArray = currentChromosomeFitnessArray;
                }
            }
            System.out.println("Scores of this Chromosome : Training :" + score_training + " Validation : " + score_validation + " Testing : " + score_testing + " Final : " + score);
        }
        //ANN ann = EvolverUtility.getANNfromChromosome(bestChromosome);
        //DataLogger.writeToFile(dataFolder+"NetworkList.dat", "bestANN"+bestChromosome.size());
        //DataLogger.writeObjectToFile(dataFolder+"bestANN"+bestChromosome.size()+".dat", ann);
        //        if (write_enabled) {


        String fdatasetString = ANNConfiguration.hiddenLNeuronCountConfig + "," + bestChromosome.size() + "," + bestChromosomeScore + "\n";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(dataFolder + "graphs/fitvsarch.txt", true));
            out.write(fdatasetString);
            out.close();
        } catch (IOException e) {
        }

        String tdatasetString = ANNConfiguration.hiddenLNeuronCountConfig + "," + bestChromosome.size() + "," + bestChromosomeTestScore + "\n";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(dataFolder + "graphs/testvsarch.txt", true));
            out.write(tdatasetString);
            out.close();
        } catch (IOException e) {
        }

        String vdatasetString = ANNConfiguration.hiddenLNeuronCountConfig + "," + bestChromosome.size() + "," + bestChromosomeValidationScore + "\n";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(dataFolder + "graphs/valivsarch.txt", true));
            out.write(vdatasetString);
            out.close();
        } catch (IOException e) {
        }

        String trdatasetString = ANNConfiguration.hiddenLNeuronCountConfig + "," + bestChromosome.size() + "," + bestChromosomeTrainingScore + "\n";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(dataFolder + "graphs/trainvsarch.txt", true));
            out.write(trdatasetString);
            out.close();
        } catch (IOException e) {
        }

        String wEvoldatasetString = bestChromosomeFitnessArray[0] + "," + bestChromosomeFitnessArray[1] + "," + "weightEvol" + (int)bestChromosomeFitnessArray[0]+ "" + (int)bestChromosomeFitnessArray[1] + ".txt" + "\n";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(dataFolder + "graphs/weightevoindex.txt", true));
            out.write(wEvoldatasetString);
            out.close();
        } catch (IOException e) {
        }

        for (int i = 2; i < bestChromosomeFitnessArray.length; i++) {
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(dataFolder + "graphs/weightEvol" + (int)bestChromosomeFitnessArray[0] + "" + (int)bestChromosomeFitnessArray[1] + ".txt", true));
                out.write(String.valueOf(bestChromosomeFitnessArray[i]) + "\n");
                out.close();
            } catch (IOException e) {
            }
        }

        return bestChromosome;
    }
}
