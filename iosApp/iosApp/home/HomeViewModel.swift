//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Natiq Haciyev on 28.07.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

@MainActor
class HomeViewModel: ObservableObject{
    
    private let getMoviesUseCase = GetAllMoviesUseCase.init()
    
    @Published private(set) var movies: [MovieModel] = []
    @Published private(set) var isLoading: Bool = false
    private (set) var loadingFinished: Bool = false
    private var currentPage = 1
    
    func loadMovies() async{
        if isLoading {
            return
        }
        
        do{
            let movies = try await getMoviesUseCase.invoke(page: Int32(currentPage))
            isLoading = false
            loadingFinished = movies.isEmpty
            
            currentPage += 1
            
            self.movies = self.movies + movies
        } catch {
            isLoading = false
            loadingFinished = true
            print("error")
        }
    }
}

