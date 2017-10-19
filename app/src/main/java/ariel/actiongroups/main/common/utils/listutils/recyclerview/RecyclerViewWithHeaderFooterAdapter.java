package ariel.actiongroups.main.common.utils.listutils.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karumi.headerrecyclerview.HeaderRecyclerViewAdapter;

import java.util.List;

import ariel.actiongroups.main.common.utils.listutils.ListPresentable;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewInterface;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;

public class RecyclerViewWithHeaderFooterAdapter extends HeaderRecyclerViewAdapter<GenericViewHolder, ListPresentable, ListPresentable, GenericViewHolder> implements GenericRecyclerViewInterface {

    private List<ListPresentable> dataSet;
    private Context context;
    private GenericViewHolder headerView;
    private ViewHoldersFactory vhFactory;

    @Override
    protected GenericViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType) {
        //final View headerView = getLayoutInflater(parent).inflate(R.layout.header_course_details, parent, false);
        return headerView;
    }

    @Override
    public GenericViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        //final View view = getLayoutInflater(parent).inflate(R.layout.vh_entity_row, parent, false);
        return vhFactory.newViewHolder();
    }

    @Override
    public void onBindItemViewHolder(GenericViewHolder holder, int position) {
        holder.itemView.setOnClickListener((View.OnClickListener) holder);
        holder.setUIDataOnView(position - 1); //-1 for header
    }

    @Override
    protected void onBindHeaderViewHolder(GenericViewHolder holder, int position) {
        holder.setUIDataOnView(0);
    }

    private LayoutInflater getLayoutInflater(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext());
    }

    @Override
    public void refreshAdapter() {
        notifyDataSetChanged();
    }



    public static class Builder {
        // Required parameters
        private List<ListPresentable> dataSet;
        private ViewHoldersFactory vhFactory;

        // Optional parameters - initialized to default values
        private Context context;
        private GenericViewHolder headerView;

        public Builder(ViewHoldersFactory vhFactory, List<ListPresentable> dataSet) {
            this.vhFactory = vhFactory;
            this.dataSet = dataSet;
        }

        public Builder withHeader(GenericViewHolder headerView) {
            this.headerView = headerView;
            return this;
        }

        public Builder withContext(Context context) {
            this.context = context;
            return this;
        }

        public RecyclerViewWithHeaderFooterAdapter build() {
            return new RecyclerViewWithHeaderFooterAdapter(this);
        }
    }
    private RecyclerViewWithHeaderFooterAdapter(Builder builder) {
        this.context = builder.context;
        this.dataSet = builder.dataSet;
        this.headerView = builder.headerView;
        this.vhFactory = builder.vhFactory;
    }

}



