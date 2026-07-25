import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.nn.modelimport.onnx.OnnxModelImporter;
import org.datavec.image.loader.NativeImageLoader;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.preprocessor.ImagePreProcessingScaler;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

class Cure {
    String cause, medicine, dosage;
    Cure(String cause, String medicine, String dosage) {
        this.cause = cause;
        this.medicine = medicine;
        this.dosage = dosage;
    }
}

public class SmartCropDoctor {

    // Disease labels (must match your trained model classes)
    private static String[] diseases = {"Healthy", "Powdery Mildew", "Leaf Blight", "Stem Rust"};

    // Cure database
    private static Map<String, Cure> diseaseMap = new HashMap<>();
    static {
        diseaseMap.put("Powdery Mildew", new Cure("Fungus", "Sulphur Fungicide", "2g per liter of water"));
        diseaseMap.put("Leaf Blight", new Cure("Bacteria", "Copper Oxychloride", "3g per liter of water"));
        diseaseMap.put("Stem Rust", new Cure("Fungus", "Propiconazole", "1ml per liter of water"));
    }

    public static void main(String[] args) throws Exception {
        // 1. Load AI model
        ComputationGraph model = OnnxModelImporter.importGraph("crop_disease.onnx");

        // 2. Preprocess image
        NativeImageLoader loader = new NativeImageLoader(224, 224, 3);
        INDArray image = loader.asMatrix(new File("crop.jpg"));
        ImagePreProcessingScaler scaler = new ImagePreProcessingScaler(0, 1);
        scaler.transform(image);

        // 3. Predict disease
        INDArray[] output = model.output(image);
        int classIndex = output[0].argMax(1).getInt(0);
        String disease = diseases[classIndex];

        // 4. Show result
        System.out.println("📸 Detected Disease: " + disease);

        // 5. Recommend cure
        Cure cure = diseaseMap.getOrDefault(disease,
                new Cure("Unknown", "Consult expert", "N/A"));

        System.out.println("Cause: " + cure.cause);
        System.out.println("Medicine: " + cure.medicine);
        System.out.println("Dosage: " + cure.dosage);
    }
}
