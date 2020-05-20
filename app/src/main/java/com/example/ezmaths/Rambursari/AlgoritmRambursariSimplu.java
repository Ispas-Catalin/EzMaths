package com.example.ezmaths.Rambursari;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class AlgoritmRambursariSimplu {

    List<String> KRambursari = new ArrayList<>();
    List<String> RKRambursari = new ArrayList<>();
    List<String> DKRambursari = new ArrayList<>();
    List<String> OmegaKRambursari = new ArrayList<>();
    List<String> QKRambursari = new ArrayList<>();

    NumberFormat format;

    double[] Rk = new double[100];
    double[] Dk = new double[100];
    double[] Qk = new double[100];
    double[] rk = new double[100];


    private void Incarcare(double Rk[], double Dk[], double Qk[],double rk[], int k)
    {
        KRambursari.add("K");
        RKRambursari.add("Rk");
        DKRambursari.add("Dk");
        QKRambursari.add("Qk");
        OmegaKRambursari.add("Ωk");

        format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(2);
        for(int i = 1; i <= k ; i ++)
        {
            KRambursari.add(Integer.toString(i));
            RKRambursari.add(format.format(Rk[i]));
            DKRambursari.add(format.format(Dk[i]));
            OmegaKRambursari.add(format.format(rk[i]));
            QKRambursari.add(format.format(Qk[i]));
        }
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


    double puterea( double numar, int pow)
    {
        double rez  = 1;
        for(int i = 1 ; i<= pow; i++)
        {
            rez = rez * numar;
        }
        return rez;
    }
    double rata_constanta(double dobanda, int numarPlatiPeAn, int numarAni, double suma )
    {
        double dobanda_2 = ((dobanda / 100)/numarPlatiPeAn);
        double rata = (dobanda_2 * suma) / ( 1 - ( 1 / puterea(1+dobanda_2 , numarPlatiPeAn * numarAni)) );
        return rata;
    }
    public void Generare_MaiMultePlati_RateConstante(double suma, int numarPlatiPeAn, int numarAni, double dobanda)
    {
        double dobanda_2;
        dobanda_2 = dobanda / 100 / numarPlatiPeAn;

        double rata;
        rata = rata_constanta(dobanda,numarPlatiPeAn,numarAni,suma);

        int k;
        k = numarAni * numarPlatiPeAn;

        for(int i = 1; i <=k ; i++)
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
    public void Generare_oSinguraPlata_RateConstante(double suma, int numarAni, double dobanda)
    {
        double dobanda_2;
        dobanda_2 = dobanda / 100;

        double rata;
        rata  =rata_constanta(dobanda, 1, numarAni, suma);

        int k;
        k = numarAni;

        for(int i = 1; i<=k ; i++)
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
    public void Generare_MaiMultePlatiPeAn_CoteConstante(double suma, int numarAni, int numarPlatiPeAn, double dobanda)
    {
        double dobanda_2;
        dobanda_2 = dobanda / 100 / numarPlatiPeAn;

        int k;
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
    public void Generare_OSinguraPlata_CoteConstante(double suma, int numarAni, double dobanda)
    {
        double dobanda_2;
        dobanda_2 = dobanda / 100;

        int k;
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

}