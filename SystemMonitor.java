import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.io.File;

public class SystemMonitor {
    public static void main(String[] args) {
        // Access system-level metrics
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);

        // Runtime for memory info
        Runtime runtime = Runtime.getRuntime();

        // Disk info
        File diskPartition = new File("C:"); // Change to your drive if needed

        // Print system performance stats
        System.out.println("=== System Performance Monitor ===");

        // CPU load
        double cpuLoad = osBean.getSystemCpuLoad() * 100;
        System.out.printf("CPU Load: %.2f%%\n", cpuLoad);

        // Memory usage
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        System.out.printf("Used Memory: %.2f MB\n", usedMemory / (1024.0 * 1024));
        System.out.printf("Free Memory: %.2f MB\n", freeMemory / (1024.0 * 1024));
        System.out.printf("Total Memory: %.2f MB\n", totalMemory / (1024.0 * 1024));

        // Physical memory (RAM)
        long totalPhysical = osBean.getTotalPhysicalMemorySize();
        long freePhysical = osBean.getFreePhysicalMemorySize();
        System.out.printf("Physical RAM Used: %.2f MB\n", 
                (totalPhysical - freePhysical) / (1024.0 * 1024));
        System.out.printf("Physical RAM Free: %.2f MB\n", 
                freePhysical / (1024.0 * 1024));

        // Disk space
        long totalDisk = diskPartition.getTotalSpace();
        long freeDisk = diskPartition.getFreeSpace();
        System.out.printf("Disk Used: %.2f GB\n", 
                (totalDisk - freeDisk) / (1024.0 * 1024 * 1024));
        System.out.printf("Disk Free: %.2f GB\n", 
                freeDisk / (1024.0 * 1024 * 1024));
    }
}
