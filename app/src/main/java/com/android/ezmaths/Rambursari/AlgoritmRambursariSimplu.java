package com.android.ezmaths.Rambursari;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class AlgoritmRambursariSimplu {

    private List<String> KRambursari = new ArrayList<>();
    private List<String> RKRambursari = new ArrayList<>();
    private List<String> DKRambursari = new ArrayList<>();
    private List<String> OmegaKRambursari = new ArrayList<>();
    private List<String> QKRambursari = new ArrayList<>();

    private NumberFormat format;

    double[] Rk = new double[100];
    double[] Dk = new double[100];
    double[] Qk = new double[100];
    double[] rk = new double[100];

    // Declarare lista string acumulare
    private List<String> K_acumulare = new ArrayList<>();
    private List<String> rk_acumulare = new ArrayList<>();
    private List<String> SinK_acumulare = new ArrayList<>();
    private List<String> SfinK_acumulare = new ArrayList<>();
    private List<String> Dk_acumulare = new ArrayList<>();
    // Declarare vectori acumulare
    double[] rk_a = new double[100];
    double[] K_a = new double[100];
    double[] SinK_a = new double[100];
    double[] Dk_a = new double[100];
    double[] SfinK_a = new double[100];


    private void Incarcare_Acumulare(double k)
    {
        if(K_acumulare!= null)
            K_acumulare.clear();
        if(rk_acumulare != null)
            rk_acumulare.clear();
        if(SfinK_acumulare != null)
            SfinK_acumulare.clear();
        if(SfinK_acumulare != null)
            SinK_acumulare.clear();
        if(Dk_acumulare != null)
            Dk_acumulare.clear();

        K_acumulare.add("K");           //loc 1 in ordinea de afisare
        rk_acumulare.add("rk");         //loc 2 in ordinea de afisare
        Dk_acumulare.add("Dk");         //loc 3 in ordinea de afisare
        SinK_acumulare.add("SinK");     //loc 4 in ordinea de afisare
        SfinK_acumulare.add("SfinK");   //loc 5 in ordinea de afisare



        format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(2);
        for(int i = 1; i <= k  ; i ++)
        {
            K_acumulare.add(Integer.toString(i));
            rk_acumulare.add(format.format(rk_a[i]));
            Dk_acumulare.add(format.format(Dk_a[i]));
            SinK_acumulare.add(format.format(SinK_a[i]));
            SfinK_acumulare.add(format.format(SfinK_a[i]));
        }

    }

    private void Incarcare(double Rk[], double Dk[], double Qk[],double rk[], double k)
    {
        if(KRambursari!= null)
            KRambursari.clear();
        if(RKRambursari != null)
            RKRambursari.clear();
        if(DKRambursari != null)
            DKRambursari.clear();
        if(OmegaKRambursari != null)
            OmegaKRambursari.clear();
        if(QKRambursari != null)
            QKRambursari.clear();

        KRambursari.add("K");
        RKRambursari.add("Rk");
        DKRambursari.add("Dk");
        QKRambursari.add("Qk");
        OmegaKRambursari.add("Ωk");

        format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(2);
        for(int i = 1; i <= k  ; i ++)
        {
            KRambursari.add(Integer.toString(i));
            RKRambursari.add(format.format(Rk[i]));
            DKRambursari.add(format.format(Dk[i]));
            OmegaKRambursari.add(format.format(rk[i]));
            QKRambursari.add(format.format(Qk[i]));
        }

        KRambursari.add("");
        RKRambursari.add("");
        DKRambursari.add("");
        QKRambursari.add("");
        OmegaKRambursari.add("");
    }

    public List<String> getK_acumulare()
    {
        return K_acumulare;
    }

    public List<String> getrk_acumulare()
    {
        return rk_acumulare;
    }

    public List<String> getSinK_acumulare()
    {
        return SinK_acumulare;
    }

    public List<String> getSfinK_acumulare()
    {
        return SfinK_acumulare;
    }

    public List<String> getDK_acumulare()
    {
        return Dk_acumulare;
    }


    public List<String> getKRambursari()
    {
        return KRambursari;
    }

    public List<String> getRKRambursari()
    {
        return RKRambursari;
    }

    public List<String> getDKRambursari()
    {
        return DKRambursari;
    }

    public List<String> getOmegaKRambursari()
    {
        return OmegaKRambursari;
    }

    public List<String> getQKRambursari(){return QKRambursari;}



    double puterea( double numar, double pow)
    {
        double rez  = 1;
        for(int i = 1 ; i<= pow; i++)
        {
            rez = rez * numar;
        }
        return rez;
    }
    double rata_constanta(double dobanda, int numarPlatiPeAn, double numarAni, double suma )
    {
        double dobanda_2 = ((dobanda / 100)/numarPlatiPeAn);
        double rata = (dobanda_2 * suma) / ( 1 - ( 1 / puterea(1+dobanda_2 , numarPlatiPeAn * numarAni)) );
        return rata;
    }
    public void Generare_MaiMultePlati_RateConstante(double suma, int numarPlatiPeAn, double numarAni, double dobanda)
    {
        double dobanda_2;
        dobanda_2 = dobanda / 100 / numarPlatiPeAn;

        double rata;
        rata = rata_constanta(dobanda,numarPlatiPeAn,numarAni,suma);

        double k;
        k = numarAni * numarPlatiPeAn;

        for(int i = 1; i <= k ; i++)
        {
            rk[i] = rata;
        }
        Rk[1] = suma;
        Dk[1] = suma * dobanda_2;
        Qk[1] = rk[1] - Dk[1];
        for(int i = 2 ; i <= k; i++)
        {
            Rk[i] = Rk[i-1] - Qk[i-1];
            Dk[i] = Rk[i] * dobanda_2;
            Qk[i] = rk[i] - Dk[i];
        }
        Incarcare(Rk,Dk,Qk,rk,k);

    }
    public void Generare_oSinguraPlata_RateConstante(double suma, double numarAni, double dobanda)
    {
        double dobanda_2;
        dobanda_2 = dobanda / 100;

        double rata;
        rata  =rata_constanta(dobanda, 1, numarAni, suma);

        double k;
        k = numarAni;

        for(int i = 1; i<= k ; i++)
        {
            rk[i] = rata;
        }
        Rk[1] = suma;
        Dk[1] = suma * dobanda_2;
        Qk[1] = rk[1] - Dk[1];

        for(int i = 2 ; i <= k; i++)
        {
            Rk[i] = Rk[i-1] - Qk[i-1];
            Dk[i] = Rk[i] * dobanda_2;
            Qk[i] = rk[i] - Dk[i];
        }
        Incarcare(Rk,Dk,Qk,rk,k);
    }
    public void Generare_MaiMultePlatiPeAn_CoteConstante(double suma, double numarAni, int numarPlatiPeAn, double dobanda)
    {
        double dobanda_2;
        dobanda_2 = dobanda / 100 / numarPlatiPeAn;

        double k;
        k = numarAni * numarPlatiPeAn;

        double cota  = suma / k;

        for ( int i = 1; i <=k ; i++)
        {
            Qk[i]  = cota;
        }
        Rk[1] = suma;
        Dk[1] = suma * dobanda_2;
        rk[1] = cota + Dk[1];
        for( int i = 2; i<=k ; i++)
        {
            Rk[i] = Rk[i-1] - cota;
            Dk[i] = Rk[i] * dobanda_2;
            rk[i] = cota + Dk[i];
        }
        Incarcare(Rk,Dk,Qk,rk,k);

    }
    public void Generare_OSinguraPlata_CoteConstante(double suma, double numarAni, double dobanda)
    {
        double dobanda_2;
        dobanda_2 = dobanda / 100;

        double k;
        k = numarAni;

        double cota  = suma / k;

        for ( int i = 1; i <=k ; i++)
        {
            Qk[i]  = cota;
        }
        Rk[1] = suma;
        Dk[1] = suma * dobanda_2;
        rk[1] = cota + Dk[1];
        for( int i = 2; i<=k ; i++)
        {
            Rk[i] = Rk[i-1] - cota;
            Dk[i] = Rk[i] * dobanda_2;
            rk[i] = cota + Dk[i];
        }
        Incarcare(Rk,Dk,Qk,rk,k);

    }

    public void Generare_Plata_Dobanzilor(double S, double nrAni, double nrPlatiPeAn,double dobanda)
    {
        dobanda = dobanda/100;
        double k = nrAni * nrPlatiPeAn;
        dobanda = dobanda / nrPlatiPeAn;
        for(int i = 1; i <= k; i++)
        {
            Rk[i] = S;
            Dk[i] = S * dobanda;
            Qk[i] = 0;
            rk[i] = Dk[i];
        }
        Qk[(int)k] = S;
        rk[(int)k] = S + Dk[(int)k];

        Incarcare(Rk,Dk,Qk,rk,k);

    }



    //FONDURI DE ACUMULARE
    double pow(double n, double a)
    {
        double result = 1;
        for(int i = 0 ; i < a; i++)
            result = result * n;
        return result;
    }
    double rata_acumulare(double S, double dobanda, double n, double nrplati)
    {
        double dobanda_u = 1 + dobanda;
        dobanda_u = pow(dobanda_u , n * nrplati);
        return  (S * dobanda) / (dobanda_u - 1);

    }
    public void generare_fond_acumulare(double S, double dobanda, double nr_ani, double nr_plati_per_an)
    {
        dobanda = dobanda/100;
        dobanda = dobanda / nr_plati_per_an; // 0.055 / 4 = 0.01375
        double k  = nr_ani * nr_plati_per_an; // mereu va fi un int
        double rata = rata_acumulare(S,dobanda,nr_ani,nr_plati_per_an);
        double dobanda_u = 1 + dobanda;

        for(int i =1; i <= k; i++ )
            rk_a[i] = rata;
        SfinK_a[1] = 0;
        SfinK_a[1] = rata;
        Dk_a[1] = 0;
        for(int i = 2; i <= k ; i++)
        {
            SinK_a[i] = SinK_a[i-1] * dobanda_u + rata;
            Dk_a[i] = SinK_a[i] * dobanda;
            SfinK_a[i] = rata + SinK_a[i] + Dk_a[i];
        }

        Incarcare_Acumulare(k);
    }
    public void generare_fond_acumulare_INTEGRAL(double S, double dobanda, double nr_ani, double nr_plati_per_an,double dobandaImprumut, double nrAniImprumut)
    {
        dobanda = dobanda/100;
        S = S * pow((dobandaImprumut + 1),nrAniImprumut);
        dobanda = dobanda / nr_plati_per_an; // 0.055 / 4 = 0.01375
        double k  = nr_ani * nr_plati_per_an; // mereu va fi un int
        double dobanda_u = 1 + dobanda;
        double rata = rata_acumulare(S,dobanda,nr_ani,nr_plati_per_an);


        for(int i =1; i <= k; i++ )
            rk_a[i] = rata;
        SfinK_a[1] = 0;
        SfinK_a[1] = rata;
        Dk_a[1] = 0;
        for(int i = 2; i <= k ; i++)
        {
            SinK_a[i] = SinK_a[i-1] * dobanda_u + rata;
            Dk_a[i] = SinK_a[i] * dobanda;
            SfinK_a[i] = rata + SinK_a[i] + Dk_a[i];
        }

        Incarcare_Acumulare(k);
    }
    public void generare_fond_acumulare_rateConstante(double dobandaF,double nrAniFond, double nrPlatiAnFond)
    {
        dobandaF = dobandaF/100;
        dobandaF = dobandaF / nrPlatiAnFond;
        double k = nrAniFond * nrPlatiAnFond;
        double dobandaU = dobandaF + 1;
        double rata = rata_acumulare(rk[1],dobandaF,nrAniFond,nrPlatiAnFond);
        for(int i =1; i <= k; i++ )
            rk_a[i] = rata;
        SfinK_a[1] = 0;
        SfinK_a[1] = rata;
        Dk_a[1] = 0;
        for(int i = 2; i <= k; i++ )
        {
            SinK_a[i] = SinK_a[i-1] * dobandaU + rata;
            Dk_a[i] = SinK_a[i] * dobandaF;
            SfinK_a[i] = rata + SinK_a[i] + Dk_a[i];
        }
        Incarcare_Acumulare(k);
    }


}