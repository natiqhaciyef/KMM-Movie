import SwiftUI
import shared


struct HomeView: View {
    
    @StateObject var viewModel = HomeViewModel()
    
    let gridColumns: [GridItem] =
    Array(repeating: GridItem(
        .flexible(), spacing:20),count: 2)
    
    let backgroundColor : Color = Color(red: 34/255, green: 35/255, blue: 40/255)


	var body: some View {
        NavigationStack{
            ScrollView{
                Text("Movies")
                    .bold()
                    .font(.title)
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .padding(20)
                    .foregroundColor(Color.white)
                
                LazyVGrid(
                    columns: gridColumns,
                    spacing: 20){
                        ForEach(viewModel.movies, id: \.id){ movie in
                            
                            NavigationLink(value: movie){
                                MovieGridItem(movie: movie).task {
                                    if movie == viewModel.movies.last && !viewModel.isLoading && viewModel.loadingFinished
                                    {
                                        await viewModel.loadMovies()
                                    }
                                }
                            }.buttonStyle(PlainButtonStyle())
                        }
                
                        if viewModel.isLoading {
                            Section(footer: ProgressView()){
                                
                            }
                        }
                    }
                    .padding(.horizontal, 15)
                    .navigationDestination(for: MovieModel.self){ movie in
                        
                    }
            }.background(backgroundColor)
        }
        .task {
            await viewModel.loadMovies()
        }
	}
}

