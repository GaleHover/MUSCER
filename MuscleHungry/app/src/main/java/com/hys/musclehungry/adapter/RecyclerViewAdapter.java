package com.hys.musclehungry.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hys.musclehungry.Handler.ShopInfo2;
import com.hys.musclehungry.R;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.NormalViewHolder> {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    ArrayList<ShopInfo2> arrayList =new ArrayList<>();
    public RecyclerViewAdapter(Context context,ArrayList<ShopInfo2> arrayList){

        System.out.println("已经进入了适配器");
        mContext=context;
        this.arrayList =arrayList;
        System.out.println(arrayList.size());
        mLayoutInflater=LayoutInflater.from(context);
    }
    public  static class NormalViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_pc;
        TextView tv_name;
        TextView price;
        TextView tv_hidden;
        TextView tv_ds;
        TextView t_dianzan;
        CardView mCardView;

        public NormalViewHolder(View itemView) {
            super(itemView);
            iv_pc=(ImageView) itemView.findViewById(R.id.iv_pic);
            mCardView=(CardView)itemView.findViewById(R.id.cv_item);
            tv_name=(TextView) itemView.findViewById(R.id.tv_name);
            price =(TextView) itemView.findViewById(R.id.jiage);
            tv_hidden = (TextView)itemView.findViewById(R.id.tv_hidden);
            tv_ds =(TextView)itemView.findViewById(R.id.descript);
            t_dianzan=(TextView)itemView.findViewById(R.id.dianza);
        }
    }
    @Override
    public NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new NormalViewHolder(mLayoutInflater.inflate(R.layout.chengpi_listview,parent,false));
    }

    /**
     * onBindViewHolder(NormalViewHolder holder, int position)
     * 专门用来绑定ViewHolder里的控件和数据源中position位置的数据。
     */
    @Override
    public void onBindViewHolder(NormalViewHolder holder, final int position) {
        ShopInfo2 sp=arrayList.get(position);
        holder.iv_pc.setImageBitmap(sp.getShoppic());
        holder.tv_name.setText(sp.getShopName());
        holder.price.setText("￥"+sp.getShopPrice()+"/份");
        holder.tv_ds.setText(sp.getDescript());
        holder.t_dianzan.setText("已赞:"+sp.getDianZan()+"");
        holder.tv_hidden.setText(sp.getHiddenID());

    }
    /**
     *
     * getItemCount()就不必多说了，和ListView是一样的
     */
    @Override
    public int getItemCount() {
        return  arrayList.size();
    }
}
