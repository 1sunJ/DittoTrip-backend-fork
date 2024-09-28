package site.dittotrip.ditto_trip.search;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.dittotrip.ditto_trip.search.dto.RankingSearchRes;

@RestController
@RequestMapping("/hot-search")
@RequiredArgsConstructor
public class RankingSearchController {

    private final RankingSearchService rankingSearchService;

    @GetMapping
    @Operation(summary = "인기 검색어 10개 조회",
            description = "")
    public RankingSearchRes rankingSearchList() {
        return rankingSearchService.findRankingSearchList();
    }

}
