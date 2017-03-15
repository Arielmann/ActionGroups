package ariel.actiongroups.main.common.utils.listutils.vh;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class GenericViewHolder extends RecyclerView.ViewHolder{

    private int tag = -1; //App crashes if try to access a tag based position without changing this default

    public GenericViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setUIDataOnView(int position);

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getTag() {
        return tag;
    }
}

