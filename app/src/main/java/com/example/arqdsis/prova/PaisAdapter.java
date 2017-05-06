package com.example.arqdsis.prova;
/**
 * Created by arqdsis on 24/03/2017.
 * @author Rafael Morcelli 201507944
 */
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PaisAdapter extends BaseAdapter {

    Pais[] paises;
    Activity context;

    public PaisAdapter(Activity context, Pais[] paises) {
        this.context = context;
        this.paises = paises;
    }

    @Override
    public int getCount() {
        return paises.length;
    }

    @Override
    public Object getItem(int i) {
        if (i >= 0 && i < paises.length) {
            return paises[i];
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View viewReciclada, ViewGroup viewGroup) {
        View view = viewReciclada;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_pais, viewGroup, false);

            ImageView foto_pais = (ImageView) view.findViewById(R.id.foto_pais);
            TextView  = (TextView) view.findViewById(R.id.);
            TextView detalheCliente = (TextView) view.findViewById(R.id.detalhe_cliente);
            //faz cache dos widgets na tagView para usar quando usar quando houver reciclagem
            view.setTag(new ViewHolder(fotoCliente, nomeCliente, detalheCliente));
        }
        //usar os widgets cacheados na tag da view reciclado
        ViewHolder holder = (ViewHolder) view.getTag();
        //carrega os novos valores
        Drawable foto = Imagem.getDrawable(context);
        holder.getFotoPais().setImageDrawable(foto);
        holder.getNome().setText(paises[i].getNome());
        holder.getArea().setText(paises[i].getArea() + "  -  " + paises[i].getArea());

        return view;
    }

}
