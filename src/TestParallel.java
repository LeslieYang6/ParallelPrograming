

public class TestParallel {
    public static int count=0;
    public static void main(String[] args)
    {
        final TestParallel data=new TestParallel();
        for(int i=0;i<10;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    for (int j = 0; j < 100; j++) {
                        data.addCount();
                    }
                    System.out.print(count + " ");
                }
            }).start();
        }
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("count="+count);
    }
    public void addCount(){
        count++;
    }
}
