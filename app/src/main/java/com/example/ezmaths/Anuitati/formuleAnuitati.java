package com.example.ezmaths.Anuitati;

public class formuleAnuitati {

    double[] Lx = {100000, 91992, 91000, 90545, 90286, 90101, 89951, 89837, 89735, 89644, 89562, 89484, 89407, 89330, 89250, 89165, 89070, 88967, 88856, 88737, 88607, 88470, 88322, 88167, 88010, 87844, 87686, 87527, 87368, 87205, 87036, 86860, 86678, 86488, 86295, 86092, 85877, 85647, 85399, 85132, 84855, 84571, 84278, 83976, 83665, 83330, 82951, 82536, 82088, 81603, 81077, 80501, 79867, 79172, 78418, 77603, 76735, 75810, 74815, 73741, 72581, 71320, 69937, 68438, 66817, 65068, 63112, 61036, 58836, 56508, 54051, 51363, 48607, 45786, 42920, 40025, 37138, 34184, 31175, 28136, 25097, 22097, 19178, 16384, 13758, 11338, 9155, 7230, 5575, 4188, 3059, 2168, 1487, 985, 628, 384, 224, 125, 66, 33, 15 };

    private double[] Dx = {100000, 87611.4, 82539.7, 78216.2, 74278.5, 70596.5, 67122.8, 63845.5, 60736.2, 57785.3, 54983.3, 52319.4, 49785.2, 47373.6, 45077.3, 42889.9, 40804, 38816, 36921.5, 35116.2, 33395.1, 31755.6, 30192.9, 28704.7, 27289.1, 25940.6, 24660.9, 23444, 22287, 21186.1, 20138.2, 19140.4, 18190.8, 17286.6, 16426.7, 15607.6, 14827.3, 14083.4, 13373.9, 12697.3, 12053.3, 11440.9, 10858.4, 10304.2, 9777.2, 9274.34, 8792.53, 8331.94, 7892.11, 7471.89, 7070.22, 6685.7, 6317.19, 5964.02, 6525.92, 5302.33, 4993.36, 4698.25, 4415.8, 4145.15, 3885.66, 3636.34, 3396.02, 3164.98, 2942.88, 2729.37, 2521.26, 2322.22, 2131.92, 1950.06, 1776.45, 1607.72, 1449, 1299.91, 1160.52, 1030.7, 910.82, 798.45, 693.49, 596.08, 506.38, 424.62, 350.98, 285.57, 228.38, 179.24, 137.84, 103.67, 76.14, 54.47, 37.89, 25.58, 16.71, 10.54, 6.4, 3.73, 2.07, 1.1, 0.55, 0.26, 0.11};

    private double[] Nx = {1811317.38, 1711317.38, 1623705.95, 1541166.27, 1462950.1, 1388671.58, 1318075.09, 1250952.27, 1187106.79, 1126370.61, 1068585.29, 1013601.99, 961282.55, 911497.38, 864123.78, 819046.46, 776156.57, 735352.58, 696536.57, 659615.07, 624498.83, 591103.78, 559348.15, 529155.28, 500450.64, 473161.56, 447220.98, 422560.11, 399116.15, 376829.13, 355643, 335504.83, 316364.4, 298173.62, 280887.05, 264460.38, 248852.74, 234025.44, 219942.02, 206568.08, 193870.81, 181817.52, 170376.62, 159518.28, 149214.05, 139436.85, 130162.51, 121369.98, 113038.04, 105145.92, 97674.03, 90603.82, 83918.12, 77600.93, 71636.91, 66010.99, 60708.66, 55715.3, 51017.05, 46601.25, 42456.09, 38570.43, 34934.1, 31538.07, 28373.09, 25430.22, 22700.84, 20179.58, 17857.36, 15725.44, 13775.38, 11998.93, 10391.21, 8942.21, 7642.3, 6481.78, 5451.08, 4540.26, 3741.81, 3048.32, 2452.23, 1945.85, 1521.23, 1170.25, 884.69, 656.31, 477.06, 339.22, 3235.55, 159.41, 104.94, 67.05, 41.48, 24.77, 14.23, 7.83, 4.1, 2.03, 0.93, 0.38, 0.11};

    private double[] Mx = {14086.27, 6271.26, 5349.27, 4946.52, 4728.17, 4579.64, 4464.95, 4381.93, 4311.18, 4251.08, 4199.49, 4152.76, 4108.83, 4066.98, 4025.58, 3983.68, 3939.09, 3893.04, 3845.78, 3797.52, 3747.32, 3696.93, 3645.08, 3593.37, 3543.49, 3493.26, 3447.73, 3404.09, 3362.53, 3321.95, 3281.88, 3242.14, 3203, 3164.09, 3126.44, 3088.73, 3050.69, 3011.94, 2972.14, 2931.33, 2891.02, 2851.65, 2812.97, 2774.99, 2737.75, 2699.55, 2658.38, 2615.45, 2571.32, 2525.81, 2478.81, 2429.79, 2378.41, 2324.76, 2269.33, 2212.27, 2154.39, 2095.65, 2035.47, 1973.61, 1909.97, 1844.09, 1775.28, 1704.24, 1631.08, 1555.91, 1475.84, 1394.9, 1313.22, 1230.9, 1148.15, 1061.93, 977.75, 895.68, 816.27, 739.88, 667.33, 596.62, 528.04, 462.06, 399.23, 340.16, 285.42, 235.52, 190.85, 151.65, 117.97, 89.68, 66.52, 48.04, 33.71, 22.94, 15.1, 9.59, 5.86, 3.44, 1.92, 1.03, 0.52, 0.25, 0.11};

    //FACTOR ACTUALIZARE VIAGER


    public double FAV(int x, int n)
    {
        return Dx[x+n]/Dx[x];
    }

    // ANUITATI VIAGERE POSTICIPATE INTREGI 1) IMEDIATA, NELIMITATA
    public double AVPI_1(int x)
    {
        return  Nx[x+1] / Dx[x];
    }

    //ANUITATI VIAGERE POSTICIPATE INTREGI 2) IMEDIATA, LIMITATA LA "N" ANI
    public double AVPI_2(int x, int n)
    {
        return (Nx[x+1] - Nx[x+n+1])/Dx[x];
    }

    //ANUITATI VIAGERE POSTICIPATE INTREGI 3) AMANATA CU "N" ANI
    public double AVPI_3( int x, int n)
    {
        return Nx[x+n+1]/Dx[x];
    }

    //ANUITATI VIAGERE POSTICIPATE FRACTIONATE 1) IMEDIATA, NELIMITATA
    public double AVPF_1( int x, int m)
    {
        double aux = (double)(m-1)/(double)(2*m);
        return AVPI_1(x) + aux ;
    }

    //ANUITATI VIAGRERE POSTICIPATE FRACTIONATE 2) IMEDIATA, LIMITATA LA "N" ANI
    public double AVPF_2( int x, int n, int m)
    {
        double aux = (double)(m-1)/(double)(2*m);
        return AVPI_2(x,n) + aux*(1-FAV(x,n));
    }

    //ANUITATI VIAGERE POSTICIPATE FRACTIONATE 3) AMANATA CU "N" ANI
    public double AVPF_3( int x, int n, int m)
    {
        double aux = (double)(m-1)/(double)(2*m);
        return AVPI_3(x,n) + aux*(FAV(x,n));
    }

    //ANUITATI VIAGERE ANTICIPATE INTREGI 1) IMEDIATA, NELIMITATA
    public double AVAI_1( int x)
    {
        return Nx[x] / Dx[x];
    }

    //ANUITATI VIAGERE ANTICIPATE INTREGI 2) IMEDIATA, LIMITATA LA "N" ANI
    public double AVAI_2( int x, int n)
    {
        return (Nx[x] - Nx[x+n]) / Dx[x];
    }

    //ANUITATI VIAGERE ANTICIPATE INTREGI 3) AMANATA CU "N" ANI
    public double AVAI_3( int x, int n)
    {
        return Nx[x+n] / Dx[x];
    }

    //ANUITATI VIAGERE ANTICIPATE FRACTIONATE 1) IMEDIATA, NELIMITATA
    public double AVAF_1( int x , int m)
    {
        double aux = (double)(m-1)/(double)(2*m);
        return AVAI_1(x) - aux;
    }

    //ANUITATI VIAGERE ANTICIPATE FRACTIONATE 2) IMEDIATA, LIMITATA LA "N" ANI
    public double AVAF_2( int x, int n , int m)
    {
        double aux = (double)(m-1)/(double)(2*m);
        return AVAI_2(x,n) - aux*(1 - FAV(x,n));
    }

    //ANUITATI VIAGERE ANTICIPATE FRACTIONATE 3) AMANATA CU "N" ANI
    public double AVAF_3( int x, int n, int m)
    {
        double aux = (double)(m-1)/(double)(2*m);
        return AVAI_3(x,n) - aux*FAV(x,n);
    }

    //ANUITATI DE DECES //

    // ANUITATI DE DECES 1)
    public double anuitatiDeces_1(int x)
    {
        return  Mx[x] / Dx[x];
    }

    //ANUITATI DE DECES DUBLU LIMITATE
    public double anuitatiDeces_2(int x, int m, int n)
    {
        return (Mx[x+m] - Mx[x+n]) / Dx[x];
    }

    //ANUITATI DE DECES LIMITATA LA N ANI
    public double anutiatiDeces_3(int x ,int n)
    {
        return (Mx[x] - Mx[x+n]) / Dx[x];
    }

    //ANUITATI DE DECES AMANATA CU N ANI
    public double anuitatiDeces_4(int x, int n)
    {
        return Mx[x+n] / Dx[x];
    }
}

