/*
java code for creating a scrollable list using recycler/card views

- need to create a model file for items in the list
- create a custom adapter 
- attach adapter to recycler view

to add a row:
- notifyItemInserted(position) in adapter
to delete a row:
- notifyItemRemoved(position) in adapter

additional methods:
- notifyItemChanged, notifyItemRangeInserted, notifyItemRangeRemoved, notifyDataSetChanged


*/

// models: Landscape.java
public class Landscape {

	// variables that are displayed on the view 
	private int imageID;
	private String title;
	private String description;

	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// gets a list of landscape objects
	public static ArrayList<Landscape> getData() {
		// return a list of all the objects
	}

}

// custom adapter file
public class adapter extends RecyclerView.Adapter<MyViewHolder> {

	private List<Landscape> mData;
	private LayoutInflater mInflater;

	// 
	public adapter(Context context, List<Landscape> data) {
		this.mData = data;
		this.mInflater = LayoutInflater.from(context);
	}

	// called when recycler view is created
	@Override 
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = mInflater.inflate(R.layout.list_item, parent, false);
		MyViewHolder holder = new MyViewHolder(view);
		return holder;
	}

	// called every row in the recycler view 
	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		Landscape currentObj = mData.get(position);
		holder.setData(currentObj, position);
		holder.setListeners(); // custom method to apply click listeners to part of the views 
	}

	// returns the number of rows in the recycler view 
	@Override
	public int getItemCount() {
		return mData.size();
	}

	// removes item from list
	public void removeItem(int position) {
		mData.remove(position); // remove data from list at position parameter
		notifyItemRemoved(position); // removes data from recycler view
		notifyItemRangeChanged(position, mData.size()); // updates the adapter the new data size
	}

	// adds item to list
	public void addItem(int position, Landscape landscape) {
		mData.add(position, landscape); // adds new item to list
		notifyItemInserted(position); // notifies view that item has been added 
		notifyItemRangeChanged(position, mData().size());
	}





	// custom class that binds the data to the view 
	// initialzes the text views and is called in the onBindViewHolder method 
	// sets the data for each card view 
	// implementing View.OnClickListener adds click events to each row 
	class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		
		TextView title;
		ImageView imgThumb, imgDelete, imgAdd;
		int poisition;
		Landscape current;


		public MyViewHolder(View itemView) {
			super(itemView);
			title = (TextView) itemView.findViewById(R.id.tvTitle);
			// initialze the rest of the fields
		}

		public void setData(Landscape current, int position) {
			this.title.setText(current.getTitle());
			// set the data methods for the rest of the fields
		}

		// sets methods for on click listeners
		public void setListeners() {
			// sets click listener to imgDelete button with viewHolder context as parameter
			imgDelete.setOnClickListener(MyViewHolder.this);
		}


		// overrides default click function to create custom functions for buttons
		@Override
		public void onClick(View v) {
			// code runs when certain button gets clicked 
			// to check the id of the clicked item
			v.getId();
		}

	}

}


// main activity file
// in the onCreate method:

// attach adapter
RecyclerView recyclerView = (RecyclerView) findViewById(id value of recycler view)
RecyclerAdapter adapter = new RecyclerAdapter(this, Landscape.getData());
recyclerView.setAdapter(adapter);

// create a linear layout manager for a linear list items
LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

// sets default animation for loading list items 
recyclerView.setItemAnimator(new DefaultItemAnimation());














