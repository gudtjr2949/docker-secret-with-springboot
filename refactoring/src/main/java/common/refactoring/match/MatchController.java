package common.refactoring.match;

import common.refactoring.match.dto.MatchFilter;
import common.refactoring.match.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @PostMapping("/list")
    public ResponseEntity<Map<String, Object>> listMatchMember(@RequestBody MatchFilter matchFilter) {
        Map<String, Object> map = new HashMap<>();
        map.put("matchList", matchService.listMatchMember(matchFilter));
        return ResponseEntity.ok(map);
    }

    @PostMapping("/v2/list")
    public ResponseEntity<Map<String, Object>> listMatchMemberV2(@RequestBody MatchFilter matchFilter) {
        Map<String, Object> map = new HashMap<>();
        map.put("matchList", matchService.listMatchMemberV2(matchFilter));
        return ResponseEntity.ok(map);
    }
}
