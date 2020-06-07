package com.android.ezmaths.Asigurari;

import com.android.ezmaths.Anuitati.formuleAnuitati;

public class FormuleAsigurari   {

    com.android.ezmaths.Anuitati.formuleAnuitati formuleAnuitati = new formuleAnuitati();
    public double asigViata_Unic_S(double P, int n, int x)
    {
        return P / formuleAnuitati.FAV(x,n);
    }
    public double asigViata_MaiMulte_S(double P, int n, int x, double anuitateP,double m)
    {
        return P * anuitateP * m / formuleAnuitati.FAV(x,n);
    }
    public double asigViata_MaiMulte_P(double S, int n, int x, double anuitateP, double m)
    {
        return S * formuleAnuitati.FAV(x,n)  / anuitateP * m;
    }
    public double asigViata_Unic_P(double S, int n, int x)
    {
        return S * formuleAnuitati.FAV(x,n);
    }
    public double asigPensie_Unic_P_fractionat(double S, double anuitateS, int m )
    {
        return S * m * anuitateS;
    }
    public double asigPensie_Unic_P_intreg(double S, double anuitateS)
    {
        return S * anuitateS;
    }
    public double asigPensie_Unic_S_fractionat(double P, double anuitateS, int m)
    {
        return P / (anuitateS * m);
    }
    public double asigPensie_Unic_S_intreg(double P, double anutiateS)
    {
        return P / anutiateS;
    }
    public double asigPensii_intreg_P_intreg(double S, double anuitateP, double anuitateS)
    {
        return (S * anuitateS) / anuitateP;
    }
    public double asigPensii_intreg_P_fractionat(double S, double anuitateP, double anuitateS, int m)
    {
        return (S * anuitateS * m ) / anuitateP;
    }
    public double asigPensii_fractionat_P_intreg(double S,double anuitateP,int n, double anuitateS)
    {
        return (S * anuitateS) / (anuitateP * n);
    }
    public double asigPensii_fractionat_P_fractionat(double S, double anuitateP, int n, double anuitateS, int m)
    {
        return (S * anuitateS * m) / (anuitateP * n);
    }
    public double asigPensii_intreg_S_intreg(double P, double anuitateP, double anuitateS)
    {
        return (P * anuitateP) / anuitateS;
    }
    public double asigPensii_intreg_S_fractionat(double P, double anuitateP, double anuitateS, int m)
    {
        return (P * anuitateP) / (anuitateS * m) ;
    }
    public double asigPensii_fractionat_S_intreg(double P, double anuitateP, int n, double anuitateS)
    {
        return ( P * anuitateP * n ) / (anuitateS );
    }
    public double asigPensii_fractionat_S_fractionat(double P, double anuitateP, int n,double anuitateS, int m)
    {
        return ( P * anuitateP * n ) / (anuitateS * m);
    }
    public double asigDeces_UNIC_P(double S, double anuitateDeces)
    {
        return S * anuitateDeces;
    }
    public double asigDeces_UNIC_S(double P, double anuitateDeces)
    {
        return P / anuitateDeces;
    }
    public double asigDeces_intreg_P(double S, double anuitateDeces, double anuitateP)
    {
        return S * anuitateDeces / anuitateP;
    }
    public double asigDeces_intreg_S(double P, double anuitateDeces, double anuitateP)
    {
        return P * anuitateP / anuitateDeces;
    }
    public double asigDeces_fractionat_P(double S, double anuitateDeces, double anuitateP, int m)
    {
        return (S * anuitateDeces) / (anuitateP * m);
    }
    public double asigDeces_fractionat_S(double P, double anuitateDeces, double anuitateP, int m)
    {
        return P * anuitateP * m / anuitateDeces;
    }

}
