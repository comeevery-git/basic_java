package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application {
    public static void main(String[] args) {
         SpringApplication.run(Application.class, args);


//        Thread thread1 = Thread.ofPlatform()
//                .name("thread1")
//                .unstarted(() -> {
//                    System.out.println("thread1");
//                    int res = 0;
//                    for(int i = 0; i < 100; i++){
//                        res += i;
//                    }
//                });
//        System.out.println("1# isVirtual:" + thread1.isVirtual());
//
//        Thread thread2 = Thread.ofVirtual()
//                .name("thread2")
//                .unstarted(() -> {
//                    System.out.println("thread2");
//                    getAllStackTraces().forEach((thread, stackTraceElements) -> {
//                        int res = 0;
//                        for(int i = 0; i < 100; i++){
//                            res += i;
//                        }
//                    });
//                });
//        System.out.println("2# isVirtual:" + thread2.isVirtual());
//
//
//        long normalStart = System.currentTimeMillis();
//        for(int i = 0; i < 100000; i++){
//            Thread th = Thread.ofPlatform().unstarted(thread1);
//            th.start();
//            try {
//                th.join();
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        long normalEnd = System.currentTimeMillis();
//
//        long vStart = System.currentTimeMillis();
//        for(int i = 0; i < 100000; i++){
//            Thread th = Thread.ofVirtual().unstarted(thread2);
//            th.start();
//            try {
//                th.join();
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        long vEnd = System.currentTimeMillis();
//
//        System.out.println("Normal Thread Time : " + (normalEnd - normalStart) / 1000);
//        System.out.println("Virtual Thread Time : " + (vEnd - vStart) / 1000);


    }
}
